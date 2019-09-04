/*
 *
 * Created by Ng on 25/7/19 9:14 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 25/7/19 9:14 AM
 *
 */

package com.ng28.popview;

import android.content.Context;

public class PopViewBuilder {
    protected Context context;
    protected boolean isFullScreen = true;
    protected String pathUrl;

    private PopViewBuilder() {
    }

    PopViewBuilder(Context context) {
        this.context = context;
    }

    public static PopViewBuilder build(Context context) {
        return new PopViewBuilder(context);
    }

    public PopViewBuilder prepare(String pathUrl) {
        this.pathUrl = pathUrl;
        return this;
    }

    public PopView create() {
        return new PopView(this);
    }
}
