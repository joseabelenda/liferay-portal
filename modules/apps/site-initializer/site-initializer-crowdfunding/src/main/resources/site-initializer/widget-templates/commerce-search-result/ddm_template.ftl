<#assign commerce_ui = PortletJspTagLibs["/META-INF/liferay-commerce-ui.tld"] />
<style>
.crowse-card{
	border-radius: 12px;
	text-decoration: none !important;
}

.crowse-card-thumbnail{
	height: 200px;
	background-size: cover !important;
	background-position: center;
	background-repeat: no-repeat;
	background: gray;
	border-radius: 12px 12px 0 0;
}

.crowse-card-thumbnail-infos{
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 14px;
}
.crowse-card-thumbnail-infos .add-to-wish-list{
    position: absolute;
    top: 14px;
    right: 30px;
		z-index: 100;
}

.crowse-card-thumbnail-infos .add-to-wish-list svg{
	color: #FF7777;
}



.crowse-card-thumbnail-infos .add-to-wish-list button span:first-child{
	display:none;
}

.crowse-card-thumbnail-infos .add-to-wish-list button:hover{
	background: #fff;
}

.crowse-card-thumbnail-infos .add-to-wish-list button span:last-child{
	margin: 0;
	padding: 0 3px;
}

.crowse-card-thumbnail-infos>span{
	background: #56BBFF;
	border-radius: 6px;
	display:inline-block;
	padding: 4px 12px;
	font-weight: 600;
	color: #fff;
	font-size: 0.875rem;
}

.crowse-card-thumbnail-infos button{
	background: #FFFFFF;
	border-radius: 6px;
	border: none;
	padding: 3px 7px;
}

.crowse-card-header{
	padding: 12px 24px;
	background: var(--color-brand-primary);
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.crowse-card-header span{
	color: #fff;
	font-size: 0.875rem;
	display: inline-block;
}

.crowse-card-header span.title{
	display:block;
	font-size: 1.4rem;
}

.crowse-card-body{
	background: #fff;
	padding: 15px 24px;
	border-radius: 0 0 12px 12px;
}

.crowse-card-body .subtitle{
	color: var(--color-brand-primary);
	font-weight: 600;
}

.crowse-card-body .title{
	color: #28282B;
	font-weight: 600;
	font-size: 1.5rem;
	height: 60px;
}

.crowse-card-body .legend{
	font-weight: 300;
	color: #28282B;
	display:block;
}

.crowse-card-body .tag{
	border: 2px solid var(--color-brand-primary);
	font-size: 0.75rem;
	display: inline-block;
	padding: 0 4px;
	border-radius: 6px;
	color: var(--color-brand-primary);
}

.crowse-card-body .progress-bar{
	background: #ECEAF8;
	border-radius: 6px;
	height: 12px;
	margin-top: 28px;
}

.crowse-card-body .progress-bar div{
	width: 50%;
	background: var(--color-brand-primary);
	height: 12px;
	border-radius: 6px;
}
</style>

<div class="container">
	<div class="row">
		<#if entries?has_content>
			<#list entries as curCPCatalogEntry>
				<#assign images = cpContentHelper.getImages(curCPCatalogEntry.getCPDefinitionId(), themeDisplay) />
				<#assign imgUrl = "" />
				<#list images as img>
					<#if img?is_first>
						<#assign imgUrl = img.getThumbnailURL() />
						<#break>
					</#if>
				</#list>
				<#assign fundingTarget = "" />
				<#assign location = "" />
				<#assign capitalGrowth = "" />
				<#assign yield = "" />
				<#list cpContentHelper.getCPDefinitionSpecificationOptionValues(curCPCatalogEntry.getCPDefinitionId()) as specification>
					<#assign key = specification.getCPSpecificationOption().key />

                    <#switch key>
				        <#case "funding-target">
					        <#assign fundingTarget = specification.value />
				            <#break>
				        <#case "location">
					        <#assign location = specification.value />
				            <#break>
				        <#case "capital-growth">
					        <#assign capitalGrowth = specification.value />
				            <#break>
				        <#case "yield">
					        <#assign yield = specification.value />
				            <#break>
			        </#switch>
				</#list>
                
				<div class="col-sm-12 col-md-4 mb-3">
					<a href="${cpContentHelper.getFriendlyURL(curCPCatalogEntry,themeDisplay)}" class="crowse-card">
						<div class="crowse-card-thumbnail" style="background-image: url('${imgUrl}')">
							<div class="crowse-card-thumbnail-infos">
								<span>Funding</span>
								<@commerce_ui["add-to-wish-list"] 
									CPCatalogEntry=curCPCatalogEntry
									large=false />
							</div>
						</div>
						<div class="crowse-card-header">
						<div>
								<span>Funding</span>
								<span class="font-weight-bold title">
								${fundingTarget}
								</span>
						</div>
						<div>
								<div>
									<span>Yield</span>	
									<span class="font-weight-bold">7.14%</span>	
								</div>
								<div>
								<span>Capital Growth</span>	
								<span class="font-weight-bold">${capitalGrowth}</span>	
							</div>
					</div>
				</div>
				<div class="crowse-card-body">
					<span class="subtitle">${location}</span>
					<h1 class="title">${curCPCatalogEntry.getName()}</h1>
					<span class="legend">BDR Capital LLC</span>
					<span class="tag">Tenured</span>
					<div class="progress-bar">
						<div></div>
					</div>
				</div>
			</a>
		</div>
		</#list>
		</#if>
		</div>
	</div>