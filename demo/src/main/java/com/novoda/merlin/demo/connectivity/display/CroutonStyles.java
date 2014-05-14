package com.novoda.merlin.demo.connectivity.display;

import android.app.Activity;

import com.novoda.merlin.demo.R;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Style;

public enum CroutonStyles {

    CONNECTED(R.string.network_connected) {
        @Override
        Style getStyle(Activity activity) {
            return createConnectedStyle(activity);
        }
    },
    DISCONNECTED(R.string.network_disconnected) {
        @Override
        Style getStyle(Activity activity) {
            return createDisconnectedStyle(activity);
        }
    };

    private static final int CONNECTED_CROUTON_DURATION = 2000;

    private final int stringResId;

    private CroutonStyles(int stringResId) {
        this.stringResId = stringResId;
    }

    public int getStringResId() {
        return stringResId;
    }

    abstract Style getStyle(Activity activity);

    private static Style createConnectedStyle(Activity activity) {
        return new Style.Builder()
                .setConfiguration(new Configuration.Builder().setDuration(CONNECTED_CROUTON_DURATION).build())
                .setBackgroundColorValue(Style.holoBlueLight)
                .build();
    }

    private static Style createDisconnectedStyle(Activity activity) {
        return new Style.Builder()
                .setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_INFINITE).build())
                .setBackgroundColorValue(Style.holoRedLight)
                .build();
    }

}