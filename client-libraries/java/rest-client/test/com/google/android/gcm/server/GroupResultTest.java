package com.google.android.gcm.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GroupResultTest {

  @Test
  public void testToString_noFailure() {
    GroupResult groupResult = new GroupResult(1, 0, null);
    assertTrue(groupResult.toString().contains("success: 1"));
    assertTrue(groupResult.toString().contains("failure: 0"));
    assertFalse(groupResult.toString().contains("failed_registration_ids"));
  }

  @Test
  public void testToString_failure() {
    GroupResult groupResult = new GroupResult(1, 3, new String[]{"reg_id1", "reg_id2", "reg_id3"});
    assertTrue(groupResult.toString().contains("success: 1"));
    assertTrue(groupResult.toString().contains("failure: 3"));
    assertTrue(groupResult.toString().contains("failed_registration_ids: [reg_id1, reg_id2, reg_id3]"));
  }
}
