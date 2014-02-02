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
package com.tkmtwo.timex.ibatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.joda.time.DateTime;
import com.tkmtwo.timex.DateTimes;


/**
 *
 */
public class DateTimeLongMillisTypeHandler
  extends BaseTypeHandler<DateTime> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());
  
  
  @Override
  public void setNonNullParameter(PreparedStatement ps, int i,
                                  DateTime parameter, JdbcType jdbcType)
    throws SQLException {

    long dtMillis = parameter.getMillis();
    logger.debug("Executing setNonNullParameter on {}, which is {}ms.",
                 DateTimes.printExtended(parameter),
                 String.valueOf(dtMillis));

    ps.setLong(i, parameter.getMillis());
  }
  
  @Override
  public DateTime getNullableResult(ResultSet rs, String columnName)
    throws SQLException {

    long dtMillis = rs.getLong(columnName);
    DateTime dt = new DateTime(dtMillis);
    logger.debug("Executing getNullableResult {}s -> {}.",
                 String.valueOf(dtMillis),
                 DateTimes.printExtended(dt));
    return dt;
  }


  @Override
  public DateTime getNullableResult(ResultSet rs, int columnIndex)
    throws SQLException {

    long dtMillis = rs.getLong(columnIndex);
    DateTime dt = new DateTime(dtMillis);
    logger.debug("Executing getNullableResult {}s -> {}.",
                 String.valueOf(dtMillis),
                 DateTimes.printExtended(dt));
    return dt;

  }

  @Override
  public DateTime getNullableResult(CallableStatement cs, int columnIndex)
    throws SQLException {

    long dtMillis = cs.getLong(columnIndex);
    DateTime dt = new DateTime(dtMillis);
    logger.debug("Executing getNullableResult {}s -> {}.",
                 String.valueOf(dtMillis),
                 DateTimes.printExtended(dt));
    return dt;

  }
}
