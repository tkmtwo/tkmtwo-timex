package com.tkmtwo.timex.convert;

import org.joda.time.DateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class IsoBasicConverterTest
{
  private IsoBasicConverter dtConverter = new IsoBasicConverter();

  @Test
  public void testInvalidStrings()
  {
    String[] ss = new String[] {
      null,
      "",
      "  ",
      "abc",
      "a34x"
    };

    for (String s : ss) {
      try {
        DateTime dt = dtConverter.convert(s);
        fail("Should not have evaluated " + String.valueOf(dt));
      } catch (IllegalArgumentException iae) {
        ; //do nothing
      }
    }
  }



  @Test
  public void testPass()
  {
    assertTrue(new DateTime(0L).isEqual(dtConverter.convert("19700101T000000Z")));
  }




}
