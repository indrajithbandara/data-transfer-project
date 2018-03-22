/*
 * Copyright 2018 The Data Transfer Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dataportabilityproject.transfer.smugmug.photos;

import com.google.common.annotations.VisibleForTesting;
import java.util.UUID;
import org.dataportabilityproject.spi.cloud.storage.JobStore;
import org.dataportabilityproject.spi.transfer.provider.ImportResult;
import org.dataportabilityproject.spi.transfer.provider.Importer;
import org.dataportabilityproject.types.transfer.auth.AuthData;
import org.dataportabilityproject.types.transfer.models.photos.PhotoAlbum;
import org.dataportabilityproject.types.transfer.models.photos.PhotoModel;
import org.dataportabilityproject.types.transfer.models.photos.PhotosContainerResource;

public class SmugMugPhotosImporter implements Importer<AuthData, PhotosContainerResource> {

  private SmugMugInterface smugMugInterface;
  private final JobStore jobStore;

  @VisibleForTesting
  SmugMugPhotosImporter(SmugMugInterface smugMugInterface, JobStore jobStore) {
    this.smugMugInterface = smugMugInterface;
    this.jobStore = jobStore;
  }

  @Override
  public ImportResult importItem(String jobId, AuthData authData, PhotosContainerResource data) {
    return null;
  }

  private void importSingleAlbum(String jobId, PhotoAlbum inputAlbum) {
    UUID uuid = UUID.fromString(jobId);


  }

  private void importSinglePhoto(String jobId, PhotoModel inputPhoto) {
    UUID uuid = UUID.fromString(jobId);


  }
}