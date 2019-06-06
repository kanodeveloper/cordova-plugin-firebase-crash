package by.chemerisuk.cordova.firebase;

import by.chemerisuk.cordova.support.CordovaMethod;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;


public class FirebaseCrashPlugin extends CordovaPlugin {

    private static final String TAG = "FirebaseCrashPlugin";
    final String argument = '';

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("log")) {
            Crashlytics.log( args.getString(0) );
            callbackContext.success();
        }
        else if (action.equals("logError")) {
            Crashlytics.logException( new Exception(args.getString(0)) );
            callbackContext.success();
        }
        else if (action.equals("setUserId")) {
            Crashlytics.setUserIdentifier( args.getString(0) );
            callbackContext.success();
        }
        return false;
    }
}
