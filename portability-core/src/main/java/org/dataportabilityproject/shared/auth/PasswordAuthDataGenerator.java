/*
 * Copyright 2018 The Data Transfer Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dataportabilityproject.shared.auth;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.UUID;
import org.dataportabilityproject.shared.IOInterface;
import org.dataportabilityproject.types.transfer.auth.AuthData;

public final class PasswordAuthDataGenerator
    implements OnlineAuthDataGenerator, OfflineAuthDataGenerator {
  @Override // offline
  public AuthData generateAuthData(IOInterface ioInterface) throws IOException {
    String account = ioInterface.ask("Enter email account");
    String password = ioInterface.ask("Enter email account password");

    return PasswordAuthData.create(account, password);
  }

  @Override
  public AuthFlowInitiator generateAuthUrl(String callbackBaseUrl, UUID jobId) throws IOException {
    return AuthFlowInitiator.create(callbackBaseUrl + "/simplelogin");
  }

  @Override // online
  public AuthData generateAuthData(
      String callbackBaseUrl, String authCode, UUID jobId, AuthData initialAuthData, String extra)
      throws IOException {
    Preconditions.checkArgument(initialAuthData == null, "initial auth data not expected");
    return PasswordAuthData.create(authCode, extra);
  }
}
