/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.gcm.server;

/**
 * Created by arthurthompson on 10/9/15.
 */
public class GroupResult {

  private long success;
  private long failure;
  private String[] failedRegistrationIds;

  public GroupResult(long success, long failure, String[] failedRegistrationIds) {
    this.success = success;
    this.failure = failure;
    this.failedRegistrationIds = failedRegistrationIds;
  }

  public long getSuccess() {
    return success;
  }

  public long getFailure() {
    return failure;
  }

  public String[] getFailedRegistrationIds() {
    return failedRegistrationIds;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Constants.JSON_SUCCESS + ": ").append(success).append(" ");
    stringBuilder.append(Constants.JSON_FAILURE + ": ").append(failure).append(" ");
    if (failedRegistrationIds != null && failedRegistrationIds.length > 0) {
      stringBuilder.append("failed_registration_ids: [");
      for (int i = 0; i < failedRegistrationIds.length; i++) {
        stringBuilder.append(failedRegistrationIds[i]);
        if (i < failedRegistrationIds.length - 1) {
          stringBuilder.append(", ");
        }
      }
      stringBuilder.append("]");
    }
    return stringBuilder.toString();
  }
}
