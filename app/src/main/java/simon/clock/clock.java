package simon.clock;

import android.service.quicksettings.TileService;

public class clock extends TileService
{
	@Override
	public void onClick()
	{
		super.onClick();
		xf.INTERFACE.in(this).show();
	}
}
