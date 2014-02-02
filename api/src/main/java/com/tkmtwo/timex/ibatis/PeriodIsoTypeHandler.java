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
import org.apache.ibatis.type.MappedJdbcTypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.joda.time.Period;
import com.tkmtwo.timex.Periods;

/**
 *
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class PeriodIsoTypeHandler
  extends BaseTypeHandler<Period> {
  
  protected final Logger logger = LoggerFactory.getLogger(getClass());

  
  @Override
  public void setNonNullParameter(PreparedStatement ps, int i,
                                  Period parameter, JdbcType jdbcType)
    throws SQLException {

    String periodString = Periods.print(parameter);
    logger.debug("Executing setNonNullParameter on {}, which is {}s.",
                 Periods.print(parameter),
                 periodString);
    ps.setString(i, periodString);
  }
  
  @Override
  public Period getNullableResult(ResultSet rs, String columnName)
    throws SQLException {
    
    return Periods.parse(rs.getString(columnName));
  }


  @Override
  public Period getNullableResult(ResultSet rs, int columnIndex)
    throws SQLException {

    return Periods.parse(rs.getString(columnIndex));
  }

  @Override
  public Period getNullableResult(CallableStatement cs, int columnIndex)
    throws SQLException {

    return Periods.parse(cs.getString(columnIndex));
  }
}
