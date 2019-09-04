/*
 *
 * Created by Ng on 24/7/19 1:23 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 24/7/19 1:23 PM
 *
 */

package com.ng28.popview;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.ng28.contextimagedialog.test", appContext.getPackageName());
    }
}
