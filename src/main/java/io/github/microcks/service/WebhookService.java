package io.github.microcks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.microcks.domain.ImportJob;
import io.github.microcks.domain.WebhookType;
import io.github.microcks.repository.ImportJobRepository;
import io.github.microcks.repository.WebhookRepository;

@Service
public class WebhookService {

    @Autowired
    WebhookRepository webhookRepository;

    @Autowired
    ImportJobRepository jobRepository;

    @Autowired
    JobService jobService;

    public boolean checkSecret(String jobId, String secret, WebhookType webhookType) {
        ImportJob job = jobRepository.findOne(jobId);
        String jobExactSecret = job.getWebhooks().get(webhookType).getSecret().toString();
        return secret.equals(jobExactSecret);
    }
}