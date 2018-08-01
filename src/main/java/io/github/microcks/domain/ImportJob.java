/*
 * Licensed to Laurent Broudoux (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.github.microcks.domain;

import org.springframework.data.annotation.Id;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain object representing an import job within Microcks.
 * Import jobs are responsible of periodically checking tests
 * &amp; mocks repository in order to update their definitions with
 * Microks own repository. They typically used the repositoryUrl
 * attribute, associated with the etag marker in order to easily
 * see if something has been updated.
 * @author laurent
 */
public class ImportJob {

   @Id
   private String id;
   private String name;
   private String repositoryUrl;
   private String frequency;
   private Date createdDate;
   private Date lastImportDate;
   private String lastImportError;
   private boolean active = false;
   private String etag;

   private Set<ServiceRef> serviceRefs;
   private HashMap<WebhookType,Webhook> webhooks;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getRepositoryUrl() {
      return repositoryUrl;
   }

   public void setRepositoryUrl(String repositoryUrl) {
      this.repositoryUrl = repositoryUrl;
   }

   public String getFrequency() {
      return frequency;
   }

   public void setFrequency(String frequency) {
      this.frequency = frequency;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public Date getLastImportDate() {
      return lastImportDate;
   }

   public void setLastImportDate(Date lastImportDate) {
      this.lastImportDate = lastImportDate;
   }

   public String getLastImportError() {
      return lastImportError;
   }

   public void setLastImportError(String lastImportError) {
      this.lastImportError = lastImportError;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public String getEtag() {
      return etag;
   }

   public void setEtag(String etag) {
      this.etag = etag;
   }

   public Set<ServiceRef> getServiceRefs() {
      return serviceRefs;
   }

   public void setServiceRefs(Set<ServiceRef> serviceRefs) {
      this.serviceRefs = serviceRefs;
   }

   public void addServiceRef(ServiceRef serviceRef) {
      if (this.serviceRefs == null) {
         this.serviceRefs = new HashSet<>();
      }
      serviceRefs.add(serviceRef);
   }

   public HashMap<WebhookType,Webhook> getWebhooks() {
      return this.webhooks;
   }

   public void setWebhooks(HashMap<WebhookType,Webhook> webhooks) {
      this.webhooks = webhooks;
   }

   public void addWebhook(Webhook webhook) {
      if (this.webhooks == null) {
         this.webhooks = new HashMap<WebhookType,Webhook>();
      }
      webhooks.put(webhook.getType(), webhook);
   }

   public Webhook removeWebhook(WebhookType type) {
       return this.getWebhooks().remove(type);
   }
}
