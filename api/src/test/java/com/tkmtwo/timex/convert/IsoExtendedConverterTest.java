package com.tkmtwo.timex.convert;

import org.joda.time.DateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class IsoExtendedConverterTest
{
  private IsoExtendedConverter dtConverter = new IsoExtendedConverter();

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
    assertTrue(new DateTime(0L).isEqual(dtConverter.convert("1970-01-01T00:00:00Z")));
  }




}
