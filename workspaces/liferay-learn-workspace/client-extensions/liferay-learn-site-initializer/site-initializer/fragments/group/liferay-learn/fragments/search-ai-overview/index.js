const getQueryParam = (name) => {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
};

const fetchSearchResults = async (query) => {
    const summaryContent = document.getElementById('summary-content');
    const toggleSummaryButton = document.getElementById('toggle-summary');
    const relatedArticlesList = document.getElementById('related-articles-list');
    const aiOverview = document.getElementById('ai-overview');
    const noResults = document.getElementById('no-results');
    const relatedArticlesTitle = document.querySelector('.related-articles-title');

    const encodedQuery = encodeURIComponent(query);
    const ragApiUrl = `https://liferaylearnetcspringboot-exte5a2learn-extuat.lfr.cloud/rag/search?question=${encodedQuery}`;
    
    summaryContent.innerHTML = 'Loading summary...';
    relatedArticlesList.innerHTML = '';
    aiOverview.classList.remove('hidden');
    noResults.classList.add('hidden');
    toggleSummaryButton.classList.add('hidden');
    relatedArticlesTitle.classList.add('hidden');
    summaryContent.classList.remove('summary-expanded');
    summaryContent.classList.add('summary-collapsed');

    try {
        const response = await fetch(ragApiUrl, {});

        if (!response.ok) {
            throw new Error(`HTTP Error: ${response.status}`);
        }

        const data = await response.json();
        
        const summary = data.response || '';
        const relatedArticles = data.reference || []; 
        
        summaryContent.innerHTML = '';

        if (summary || relatedArticles.length > 0) {
            
            if (summary) {
                summaryContent.innerHTML = summary; 

                const summaryTextLength = summaryContent.textContent.length;
                const threshold = 300;

                if (summaryTextLength > threshold) {
                    toggleSummaryButton.classList.remove('hidden');
                    toggleSummaryButton.textContent = 'Show More';
                } else {
                    toggleSummaryButton.classList.add('hidden');
                }
            } else {
                summaryContent.innerHTML = '<p>No summary available.</p>';
            }

            if (relatedArticles.length > 0) {
                relatedArticlesTitle.classList.remove('hidden');
                
                relatedArticles.forEach(article => {
                    const listItem = document.createElement('li');
                    const link = document.createElement('a');
                    
                    const articleLink = `/l/${article.assetEntryId}`;

                    link.href = articleLink;
                    link.textContent = `${article.name} (${article.assetEntryType})`; 
                    
                    listItem.appendChild(link);
                    relatedArticlesList.appendChild(listItem);
                });
            } else {
                relatedArticlesTitle.classList.add('hidden');
            }
            
            aiOverview.classList.remove('hidden');
            noResults.classList.add('hidden');

        } else {
            aiOverview.classList.add('hidden');
            noResults.classList.remove('hidden');
        }

    } catch (error) {
        console.error('Error fetching search results:', error);
        summaryContent.innerHTML = `<p>Error loading results. Please check the API URL or server status. (${error.message})</p>`;
        relatedArticlesList.innerHTML = ''; 
        aiOverview.classList.remove('hidden');
        noResults.classList.add('hidden');
    }
};

document.getElementById('toggle-summary').addEventListener('click', function() {
    const summaryContent = document.getElementById('summary-content');
    if (summaryContent.classList.contains('summary-collapsed')) {
        summaryContent.classList.remove('summary-collapsed');
        summaryContent.classList.add('summary-expanded');
        this.textContent = 'Show Less';
    } else {
        summaryContent.classList.remove('summary-expanded');
        summaryContent.classList.add('summary-collapsed');
        this.textContent = 'Show More';
    }
});

const searchQuery = getQueryParam('q'); 

if (searchQuery) {
    fetchSearchResults(searchQuery); 
}
else {
    document.getElementById('ai-overview').classList.add('hidden');
    document.getElementById('no-results').classList.remove('hidden');
    document.getElementById('no-results').innerHTML = 'Please provide a search term using the <b>q</b> URL parameter.';
}