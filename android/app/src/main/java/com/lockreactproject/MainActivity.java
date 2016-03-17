package com.lockreactproject;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import com.auth0.lock.react.LockReactPackage;
import com.auth0.core.Strategies;
import com.auth0.facebook.FacebookIdentityProvider;
import com.auth0.googleplus.GooglePlusIdentityProvider;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "LockReactProject";
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    /**
     * A list of packages used by the app. If the app uses additional views
     * or modules besides the default ones, add more packages here.
     */
    @Override
    protected List<ReactPackage> getPackages() {
        LockReactPackage lockReactPackage = new LockReactPackage();
        lockReactPackage.addIdentityProvider(Strategies.Facebook, new FacebookIdentityProvider(this));
        lockReactPackage.addIdentityProvider(Strategies.GooglePlus, new GooglePlusIdentityProvider(this));
        return Arrays.<ReactPackage>asList(
            new MainReactPackage(),
            lockReactPackage
        );
    }
}
