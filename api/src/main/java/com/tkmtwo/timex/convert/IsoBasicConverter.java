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

package com.tkmtwo.timex.convert;


import org.springframework.core.convert.converter.Converter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;


/**
 * Coverts a <code>String</code> to a JodaTime <code>DateTime</code>
 * consistent with Spring's <code>Converter</code> facility.
 *
 * <p>
 * This converter uses JodaTime's <code>ISODateTimeFormat.basicDateTimeNoMillis()</code>.
 * It expects format <code>yyyy-MM-dd'T'HH:mm:ssZZ</code>.
 *
 * @author Tom Mahaffey
 * @see org.springframework.core.convert.converter.Converter
 * @see org.joda.time.format.ISODateTimeFormat#basicDateTimeNoMillis()
 */
public final class IsoBasicConverter
  implements Converter<String, DateTime> {

  @Override
  public DateTime convert(String s) {
    checkArgument(!isNullOrEmpty(s), "DateTime string is empty.");
    return ISODateTimeFormat.basicDateTimeNoMillis().parseDateTime(s);
  }
}
