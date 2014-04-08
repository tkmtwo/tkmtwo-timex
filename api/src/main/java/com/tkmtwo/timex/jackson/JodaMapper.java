/*
 *
 * Copyright 2014 Tom Mahaffey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tkmtwo.timex.jackson;


import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tkmtwo.timex.DateTimes;

/**
 *
 */
public final class JodaMapper
  extends ObjectMapper {

  private static final long serialVersionUID = 1L;
  
  public JodaMapper() {
    this(DateTimes.getExtendedFormatter());
  }
  public JodaMapper(DateTimeFormatter dtf) {
    registerModule(new JodaModule(dtf));
  }
  
  
}
