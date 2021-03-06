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
package org.dataportabilityproject.serviceProviders.rememberTheMilk.model;

import com.google.api.client.util.Key;
import com.google.common.base.Joiner;
import java.util.List;

/** A set of task lists. */
public class Tasks {

  @Key("@rev")
  public String rev;

  @Key("list")
  public List<TaskList> list;

  @Override
  public String toString() {
    return String.format(
        "Tasks(rev=%s List=%s)",
        rev, (null == list || list.isEmpty()) ? "" : Joiner.on("\n").join(list));
  }
}
