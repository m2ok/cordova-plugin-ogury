package io.presage;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import io.presage.Presage;
import io.presage.IADHandler;
import android.util.Log;
import org.apache.cordova.CallbackContext;

/**
 * This class is used to do Presage calls
 */
public class CPresage extends CordovaPlugin {

    private static final String AD_TO_SERVE		= "adToServe";
    private static final String LAUNCH_WITH_EULA	= "launchWithEula";
    private static final String LOAD_INTERSTITIAL	= "loadInterstitial";
    private static final String SHOW_INTERSTITIAL	= "showInterstitial";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(AD_TO_SERVE)) {
            adToServe(callbackContext);
            return true;
        }
	if (action.equals(LAUNCH_WITH_EULA)) {
	    launchWithEula(callbackContext);
            return true;
        }
	if (action.equals(LOAD_INTERSTITIAL)) {
            loadInterstitial(callbackContext);
            return true;
        }
	if (action.equals(SHOW_INTERSTITIAL)) {
            showInterstitial(callbackContext);
            return true;
        }
        return false;
    }

    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Presage.getInstance().setContext(cordova.getActivity().getApplicationContext());
            }
        });
        this.start();
    }

    private void start() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Presage.getInstance().start();
            }
        });
    }

    public void loadInterstitial(final CallbackContext callbackContext)
    {
	cordova.getActivity().runOnUiThread(new Runnable() {
		public void run() {
		    Presage.getInstance().loadInterstitial(new IADHandler() {
	       @Override
		public void onAdNotFound() {
		    callbackContext.error("AdNotFound");
		}

		@Override
		public void onAdFound() {
		    PluginResult adFountResult = new PluginResult(PluginResult.Status.OK, "AdFound");
		    adFountResult.setKeepCallback(false);
		    callbackContext.sendPluginResult(adFountResult);
		}
		
		@Override
		public void onAdClosed() {
		    PluginResult adClosedResult = new PluginResult(PluginResult.Status.OK, "AdClosed");
		    adClosedResult.setKeepCallback(true);
		    callbackContext.sendPluginResult(adClosedResult);
		}
		
		@Override
		public void onAdError(int code) {
		    // TODO Auto-generated method stub
		}
		
		@Override
		public void onAdDisplayed() {
		    // TODO Auto-generated method stub
		}
		
	    });
		}
	    });
    }

    public void showInterstitial(final CallbackContext callbackContext)
    {
	cordova.getActivity().runOnUiThread(new Runnable() {
		public void run() {
		    Presage.getInstance().showInterstitial(new IADHandler() {
		@Override
		public void onAdNotFound() {
		    callbackContext.error("AdNotFound");
		}

		@Override
		public void onAdFound() {
		    PluginResult adFountResult = new PluginResult(PluginResult.Status.OK, "AdFound");
		    adFountResult.setKeepCallback(false);
		    callbackContext.sendPluginResult(adFountResult);
		}
		
		@Override
		public void onAdClosed() {
		    PluginResult adClosedResult = new PluginResult(PluginResult.Status.OK, "AdClosed");
		    adClosedResult.setKeepCallback(true);
		    callbackContext.sendPluginResult(adClosedResult);
		}
		
		@Override
		public void onAdError(int code) {
		    // TODO Auto-generated method stub
		}
		
		@Override
		public void onAdDisplayed() {
		    // TODO Auto-generated method stub
		}
		
	    });
		}
	    });
    }
    
    public void launchWithEula(final CallbackContext callbackContext)
    {
	cordova.getActivity().runOnUiThread(new Runnable() {
		public void run() {
		    Presage.getInstance().launchWithEula( new IEulaHandler() {
			    @Override
			    public void onEulaFound() {
				PluginResult adFountResult = new PluginResult(PluginResult.Status.OK, "AdFound");
				adFountResult.setKeepCallback(false);
				callbackContext.sendPluginResult(adFountResult);
			    }
			    
			    @Override
			    public void onEulaNotFound() {
				PluginResult adNotFountResult = new PluginResult(PluginResult.Status.OK, "AdNotFound");
				adNotFountResult.setKeepCallback(false);
				callbackContext.sendPluginResult(adNotFountResult);
			    }
			    
			    @Override
			    public void onEulaClosed() {
				PluginResult adClosedResult = new PluginResult(PluginResult.Status.OK, "AdClosed");
				adClosedResult.setKeepCallback(true);
				callbackContext.sendPluginResult(adClosedResult);
			    }
			});
		}
	    });
    }
    
    private void adToServe(final CallbackContext callbackContext) {
        Presage.getInstance().adToServe( new IADHandler() {
		@Override
		public void onAdNotFound() {
		    callbackContext.error("AdNotFound");
		}

		@Override
		public void onAdFound() {
		    PluginResult adFountResult = new PluginResult(PluginResult.Status.OK, "AdFound");
		    adFountResult.setKeepCallback(false);
		    callbackContext.sendPluginResult(adFountResult);
		}
		
		@Override
		public void onAdClosed() {
		    PluginResult adClosedResult = new PluginResult(PluginResult.Status.OK, "AdClosed");
		    adClosedResult.setKeepCallback(true);
		    callbackContext.sendPluginResult(adClosedResult);
		}
		
		@Override
		public void onAdError(int code) {
		    // TODO Auto-generated method stub
		}
		
		@Override
		public void onAdDisplayed() {
		    // TODO Auto-generated method stub
		}
		
	    });
    }
}
