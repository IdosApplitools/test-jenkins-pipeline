import com.applitools.eyes.*;
import com.applitools.eyes.images.Eyes;
import com.applitools.eyes.images.Target;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImagesTest {

    @Test
    public void t3176() {
        Eyes eyes = new Eyes();
        eyes.setBatch(new BatchInfo().withBatchId(System.getenv("APPLITOOLS_BATCH_ID")));
        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        eyes.setViewportSize(new RectangleSize(1000,600));

        try {
            // Start the test with a viewport size of 800x600.
            eyes.open("viewport size debug", "viewport size debug");

            // Load page image and validate.
            BufferedImage img = ImageIO.read(
                    new URL("https://ewig5qf9cgn.exactdn.com/wp-content/uploads/2014/07/new-logo.png?strip=all&lossy=1&ssl=1")
            );

            // // Visual validation.
            eyes.check("a", Target.image(img).fully(true));
            eyes.check("a", Target.image(img).fully(false));

            // End visual UI testing.
            System.out.println(eyes.close());
        } catch(IOException ex){
            System.out.println(ex);
        } finally {
            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();
        }
    }
}
