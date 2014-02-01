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
 *
 */
@MappedJdbcTypes(JdbcType.INTEGER)
public class WallClockIntSecsTypeHandler
  extends BaseTypeHandler<WallClock> {
  
  
  @Override
  public void setNonNullParameter(PreparedStatement ps, int i,
                                  WallClock parameter, JdbcType jdbcType)
    throws SQLException {
    
    ps.setInt(i, parameter.getSeconds());
  }
  
  @Override
  public WallClock getNullableResult(ResultSet rs, String columnName)
    throws SQLException {
    
    return WallClock.valueOf(rs.getInt(columnName));
  }


  @Override
  public WallClock getNullableResult(ResultSet rs, int columnIndex)
    throws SQLException {

    return WallClock.valueOf(rs.getInt(columnIndex));
  }

  @Override
  public WallClock getNullableResult(CallableStatement cs, int columnIndex)
    throws SQLException {

    return WallClock.valueOf(cs.getInt(columnIndex));
  }
}
