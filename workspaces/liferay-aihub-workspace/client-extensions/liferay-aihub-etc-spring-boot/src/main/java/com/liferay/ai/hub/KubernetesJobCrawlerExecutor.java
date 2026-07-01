/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ai.hub;

import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author José Abelenda
 */
@ConditionalOnProperty(
	havingValue = "kubernetes-jobs", name = "liferay.ai.hub.crawler.executor"
)
@Service
public class KubernetesJobCrawlerExecutor implements CrawlerExecutor {

	public KubernetesJobCrawlerExecutor(
		KubernetesClient kubernetesClient,
		@Value("${liferay.ai.hub.crawler.elasticsearch.host}") String
			elasticsearchHost,
		@Value("${liferay.ai.hub.crawler.elasticsearch.port}") int
			elasticsearchPort,
		@Value("${liferay.ai.hub.crawler.k8s.image}") String image,
		@Value("${liferay.ai.hub.crawler.log.level}") String crawlerLogLevel,
		@Value("${liferay.ai.hub.crawler.k8s.namespace}") String namespace) {

		_kubernetesClient = kubernetesClient;
		_elasticsearchHost = elasticsearchHost;
		_elasticsearchPort = elasticsearchPort;
		_image = image;
		_crawlerLogLevel = crawlerLogLevel;
		_namespace = namespace;
	}

	@Override
	public String execute(CrawlerExecutorInput crawlerExecutorInput) {
		String suffix = UUID.randomUUID(
		).toString(
		).substring(
			0, 8
		);

		String jobName = "aihub-crawler-" + suffix;

		Job job = new JobBuilder(
		).withNewMetadata(
		).withName(
			jobName
		).withNamespace(
			_namespace
		).addToLabels(
			"app", "aihub-crawler"
		).endMetadata(
		).withNewSpec(
		).withBackoffLimit(
			1
		).withTtlSecondsAfterFinished(
			3600
		).withNewTemplate(
		).withNewMetadata(
		).addToLabels(
			"app", "aihub-crawler"
		).endMetadata(
		).withNewSpec(
		).withRestartPolicy(
			"Never"
		).withNewSecurityContext(
		).withRunAsUser(
			1000L
		).withRunAsGroup(
			1000L
		).withRunAsNonRoot(
			true
		).withNewSeccompProfile(
		).withType(
			"RuntimeDefault"
		).endSeccompProfile(
		).endSecurityContext(
		).addNewContainer(
		).withName(
			"crawler"
		).withImage(
			_image
		).addNewEnv(
		).withName(
			"CRAWLER_DOMAIN_URL"
		).withValue(
			crawlerExecutorInput.getDomainUrl()
		).endEnv(
		).addNewEnv(
		).withName(
			"CRAWLER_OUTPUT_INDEX"
		).withValue(
			crawlerExecutorInput.getIndexName()
		).endEnv(
		).addNewEnv(
		).withName(
			"CRAWLER_SEED_URL"
		).withValue(
			crawlerExecutorInput.getSeedUrl()
		).endEnv(
		).addNewEnv(
		).withName(
			"ELASTICSEARCH_HOST"
		).withValue(
			_elasticsearchHost
		).endEnv(
		).addNewEnv(
		).withName(
			"ELASTICSEARCH_PORT"
		).withValue(
			String.valueOf(_elasticsearchPort)
		).endEnv(
		).addNewEnv(
		).withName(
			"CRAWLER_LOG_LEVEL"
		).withValue(
			_crawlerLogLevel
		).endEnv(
		).withNewSecurityContext(
		).withAllowPrivilegeEscalation(
			false
		).withNewCapabilities(
		).withDrop(
			"ALL"
		).endCapabilities(
		).endSecurityContext(
		).endContainer(
		).endSpec(
		).endTemplate(
		).endSpec(
		).build();

		_kubernetesClient.batch(
		).v1(
		).jobs(
		).inNamespace(
			_namespace
		).resource(
			job
		).create();

		if (_log.isInfoEnabled()) {
			_log.info("Kubernetes Job dispatched: " + jobName);
		}

		return "k8s:" + jobName;
	}

	private static final Log _log = LogFactory.getLog(
		KubernetesJobCrawlerExecutor.class);

	private final String _crawlerLogLevel;
	private final String _elasticsearchHost;
	private final int _elasticsearchPort;
	private final String _image;
	private final KubernetesClient _kubernetesClient;
	private final String _namespace;

}