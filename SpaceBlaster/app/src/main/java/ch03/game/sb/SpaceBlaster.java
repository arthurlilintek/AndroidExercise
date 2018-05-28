package ch03.game.sb;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SpaceBlaster extends Activity {
	private View view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LayoutInflater factory = LayoutInflater.from(this);
        
        // Set game layout
        view = factory.inflate(R.layout.main, null);
        setContentView(view);
        
       
        // Enable view key events
		view.setFocusable(true);
		view.setFocusableInTouchMode(true);
        
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	
    	MenuItem item01 = menu.add(0, 0, Menu.NONE, "Exit");
    	item01.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
    	
    	
    	// 
    	item01.setShortcut('1', 'a');
    	
    	return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getGroupId() == 0) {
    		finish();
    	} else {
    		return super.onOptionsItemSelected(item);
    	}
    	return true;
    }
	
    @Override
    protected void onStop() {
    	super.onStop();
    	((ArcadeGame)view).halt();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	onStop();
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	((ArcadeGame)view).resume();
    }
}