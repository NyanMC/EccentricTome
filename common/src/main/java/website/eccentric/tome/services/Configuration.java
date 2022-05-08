package website.eccentric.tome.services;

import java.util.List;
import java.util.Map;

public interface Configuration {
    
    public boolean allItems();
    public boolean disableOverlay();
    public List<? extends String> items();
    public List<? extends String> names();
    public Map<String, String> aliases();
    public List<? extends String> exclude();
    public List<? extends String> excludeItems();
    public void refresh();
}
