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

package org.dataportabilityproject.datatransfer.flickr.photos;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.photosets.Photoset;
import org.dataportabilityproject.types.transfer.auth.AuthData;
import org.dataportabilityproject.types.transfer.auth.TokenSecretAuthData;
import org.scribe.model.Token;

import static com.google.common.base.Preconditions.checkArgument;

public class FlickrUtils {
  public static Auth getAuth(AuthData authData, Flickr flickr) throws FlickrException {
    checkArgument(
            authData instanceof TokenSecretAuthData,
            "authData expected to be TokenSecretAuthData not %s",
            authData.getClass().getCanonicalName());
    TokenSecretAuthData tokenAuthData = (TokenSecretAuthData) authData;
    Token requestToken = new Token(tokenAuthData.getToken(), tokenAuthData.getSecret());
    return flickr.getAuthInterface().checkToken(requestToken);
  }
}
