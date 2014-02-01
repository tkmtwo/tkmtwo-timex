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

import com.tkmtwo.timex.WallClock;

/**
 * Handles <code>WallClock</code> to <code>VARCHAR</code> using
 * the basic format <code>HHMMSS</code>.
 *
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class WallClockBasicTypeHandler
  extends BaseTypeHandler<WallClock> {
  
  
  @Override
  public void setNonNullParameter(PreparedStatement ps, int i,
                                  WallClock parameter, JdbcType jdbcType)
    throws SQLException {
    
    ps.setString(i, parameter.printBasic());
  }
  
  @Override
  public WallClock getNullableResult(ResultSet rs, String columnName)
    throws SQLException {
    
    return WallClock.parseBasic(rs.getString(columnName));
  }


  @Override
  public WallClock getNullableResult(ResultSet rs, int columnIndex)
    throws SQLException {

    return WallClock.parseBasic(rs.getString(columnIndex));
  }

  @Override
  public WallClock getNullableResult(CallableStatement cs, int columnIndex)
    throws SQLException {

    return WallClock.parseBasic(cs.getString(columnIndex));
  }
}
