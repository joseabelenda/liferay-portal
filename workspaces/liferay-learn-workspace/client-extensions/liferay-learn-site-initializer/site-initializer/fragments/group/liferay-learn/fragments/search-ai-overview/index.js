const fetchSearchResults = async (query) => {
    const summaryContent = document.getElementById('summary-content');
    const relatedArticlesContainer = document.getElementById('related-articles-container');

    const encodedQuery = encodeURIComponent(query);
    const ragApiUrl = `https://liferaylearnetcspringboot2-exte5a2learn-extprd.lfr.cloud/rag/search?question=${encodedQuery}`;

    try {
        const data = {
  "summary": "Liferay DXP (Digital Experience Platform) enables you to build, manage, and optimize digital experiences across web, mobile, and connected devices. Here's a quick overview of how to get started:\n<ol>\n\t<li>\n\t\t<strong>Install Liferay DXP</strong>\n\t\t<p style=\"margin-bottom: 15px;\">To begin, install Liferay DXP on your preferred environment (local, cloud, or containerized setup).</p>\n\t</li>\n\t<li>\n\t\t<strong>Understand the Platform Architecture</strong>\n\t\t<p>Familiarize yourself with Platform DXP's architecture, including its modular OSGi-based structure, core services, and extension points.</p>\n\t</li>\n\t<li>\n\t\t<strong>Create and Manage Sites</strong>\n\t\t<p>Use the Site Administration tools to create and manage sites, pages, navigation menus, and layouts.</p>\n\t</li>\n\t<li>\n\t\t<strong>Add and Configure Applications (Widgets)</strong>\n\t\t<p>Drag and drop built-in apps (widgets) to your pages and configure them using the UI or code.</p>\n\t</li>\n\t<li>\n\t\t<strong>Customize with Themes, Fragments, and Templates</strong>\n\t\t<p>Use Themes and Fragments to align the look and feel of your site with your brand.</p>\n\t</li>\n\t<li>\n\t\t<strong>Develop Custom Features</strong>\n\t\t<p>If you need custom logic or applications, use Liferay's Developer Tools to create portlets, REST APIs, and service modules.</p>\n\t</li>\n\t<li>\n\t\t<strong>Manage Users and Permissions</strong>\n\t\t<p>Control access using user roles, permissions, and organizations.</p>\n\t</li>\n</ol>",
  "references": [
    {
      "assetEntryId": "33222485",
      "chunk_index": 2,
      "distance": 0.14272362,
      "name": "React Component Utilities Reference",
      "assetEntryType": "Journal Article",
      "parent_document_id": "cb7d7f06-74f7-4dd7-8fa1-e083807f30ee",
      "total_chunks": 3,
      "friendlyUrlPath": "dxp/development/traditional-java-based-development/developing-a-web-application/using-react/react-component-utilities-reference"
    },
    {
      "assetEntryId": "33228358",
      "chunk_index": 2,
      "distance": 0.14647591,
      "name": "Workflow Transitions",
      "assetEntryType": "Journal Article",
      "parent_document_id": "1109207f-7160-4554-a86c-ba6c7af2f552",
      "total_chunks": 3,
      "friendlyUrlPath": "dxp/low-code/workflow/designing-and-managing-workflows/workflow-designer/workflow-transitions"
    },
    {
      "assetEntryId": "37614504",
      "chunk_index": 2,
      "distance": 0.14647591,
      "assetEntryType": "Journal Article",
      "name": "Waiting for Life Cycle Events",
      "parent_document_id": "4dc26cba-f714-47c5-a041-fc411473f5b4",
      "total_chunks": 3,
      "friendlyUrlPath": "dxp/development/traditional-java-based-development/extending-liferay/waiting-for-lifecycle-events"
    }
  ]
}
        
        const summary = data.summary || '';

        console.log('data', data);

        const references = data.references || []; 
        
        summaryContent.innerHTML = '';

        if (summary || references.length > 0) {
            
            if (summary) {
                summaryContent.innerHTML = summary; 
            } else {
                summaryContent.innerHTML = '<p>No summary available.</p>';
            }

            if (references.length > 0) {
                references.forEach(article => {
                    const liElement = document.createElement('li');

                    const icon = document.createElement('span');

                    icon.classList.add('ai-icon');

                    const relatedLink = document.createElement('a');

                    relatedLink.href = '#';
                    relatedLink.textContent = 'How do I deploy Liferay DXP to the cloud?';

                    liElement.appendChild(icon);
                    liElement.appendChild(relatedLink);
                    
                    relatedArticlesContainer.appendChild(liElement);
                });
            } else {
                // relatedArticlesTitle.classList.add('hidden');
            }
            
            // aiOverview.classList.remove('hidden');
            // noResults.classList.add('hidden');

        } else {
            // aiOverview.classList.add('hidden');
            // noResults.classList.remove('hidden');
        }
    }
    catch (error) {
        console.error('Error fetching search results:', error);
        summaryContent.innerHTML = `<p>Error loading results. Please check the API URL or server status. (${error.message})</p>`;
        relatedArticles.innerHTML = ''; 
    }
    
}

function toggleCard() {
    const content = document.getElementById('mainContent');
    const button = document.querySelector('.toggle-button');
    const isCollapsed = content.classList.toggle('collapsed');

    if (isCollapsed) {
        button.textContent = 'Show More';
        
        // Oculta o footer quando colapsado, se desejar
        document.querySelector('.card-footer').style.display = 'none';
        document.querySelector('.card-body p').style.marginBottom = '0'; // Ajusta margem do parágrafo inicial
    } else {
        button.textContent = 'Show Less';
        
        // Mostra o footer
        document.querySelector('.card-footer').style.display = 'block';
        document.querySelector('.card-body p').style.marginBottom = '15px';
    }
}

const toggleButton = document.querySelector('.toggle-button');

if (toggleButton) {
    toggleButton.addEventListener('click', toggleCard);
}


toggleCard();
fetchSearchResults('');