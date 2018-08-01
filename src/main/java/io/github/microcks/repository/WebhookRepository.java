package io.github.microcks.repository;

import io.github.microcks.domain.Webhook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebhookRepository extends MongoRepository<Webhook, String> {

    Webhook findOneById(String id);
    
}