/*
 * Copyright 2018 The Data-Portability Project Authors.
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
package org.dataportabilityproject.gateway.reference;

import com.google.inject.Inject;
import com.sun.net.httpserver.HttpHandler;
import org.dataportabilityproject.gateway.ApiSettings;
import org.dataportabilityproject.security.SymmetricKeyGenerator;
import org.dataportabilityproject.spi.cloud.storage.JobStore;
import org.dataportabilityproject.api.launcher.TypeManager;
import org.dataportabilityproject.spi.gateway.auth.AuthServiceProviderRegistry;

/** {@link HttpHandler} that handles starting a copy job. */
final class CopySetupHandler extends SetupHandler {

  static final String PATH = "/_/copySetup";

  @Inject
  CopySetupHandler(
      AuthServiceProviderRegistry registry,
      JobStore store,
      SymmetricKeyGenerator symmetricKeyGenerator,
      ApiSettings apiSettings,
      TokenManager tokenManager,
      TypeManager typeManager) {
    super(
        registry,
        apiSettings,
        store,
        symmetricKeyGenerator,
        Mode.COPY,
        PATH,
        tokenManager,
        typeManager);
  }
}
