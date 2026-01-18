package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Showcase example that renders the content of a ZIP archive using GroupDocs Viewer.
 * <p>
 * The example reads a sample ZIP file from {@code resources/input/} directory and renders the
 * archive's files as HTML pages into {@code resources/output/} directory.
 * </p>
 */
public class RenderZipArchivesExample {

    private static final String INPUT_ZIP_PATH = "resources/input/sample.zip";
    private static final String OUTPUT_DIR = "resources/output/";
    private static final String LICENSE_FILE = "GroupDocs.Viewer.Java.lic";

    /**
     * Loads the GroupDocs Viewer license.
     * <p>
     * To get a temporary license, visit:
     * https://purchase.groupdocs.com/temporary-license/
     * </p>
     * <p>
     * Place the license file in the project root directory (same level as pom.xml). If the
     * license file is not present the library will run in evaluation mode with watermarks and
     * functional limitations.
     * </p>
     *
     * @param licensePath path to the license file relative to project root
     */
    public static void loadLicense(String licensePath) {
        Path path = Paths.get(licensePath);
        if (Files.exists(path)) {
            try {
                License license = new License();
                license.setLicense(licensePath);
                System.out.println("GroupDocs Viewer license loaded successfully.");
            } catch (Exception e) {
                System.err.println("Failed to load GroupDocs Viewer license: " + e.getMessage());
            }
        } else {
            System.out.println("License file not found at " + licensePath + ". Running in evaluation mode.");
        }
    }

    /**
     * Renders the ZIP archive to HTML.
     * <p>
     * The method performs the following steps:
     * <ul>
     *   <li>Ensures the output directory exists.</li>
     *   <li>Creates a {@link Viewer} instance for the ZIP file.</li>
     *   <li>Defines {@link HtmlViewOptions} with the output folder.</li>
     *   <li>Calls {@code viewer.view(options)} which generates HTML pages for each file inside the archive.</li>
     * </ul>
     * </p>
     *
     * @throws Exception if rendering fails
     */
    public static void renderZipArchive() throws Exception {
        // Verify input ZIP exists
        File zipFile = new File(INPUT_ZIP_PATH);
        if (!zipFile.exists()) {
            throw new IllegalArgumentException("Input ZIP file not found at " + INPUT_ZIP_PATH);
        }

        // Create output directory if it does not exist
        Path outputDir = Paths.get(OUTPUT_DIR);
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
            System.out.println("Created output directory: " + OUTPUT_DIR);
        }
        Path pageFilePathFormat = outputDir.resolve("result_{0}.png");
        // Initialize Viewer for the ZIP archive
        try (Viewer viewer = new Viewer(INPUT_ZIP_PATH)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            // Render the archive. The API will generate an index.html and separate page for each file.
            viewer.view(options);
            System.out.println("ZIP archive rendered successfully. Check the output folder: " + OUTPUT_DIR);
        }
    }

    /**
     * Main entry point.
     * <p>
     * Loads the license (if present) and then renders the sample ZIP archive.
     * </p>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Load license if available
        loadLicense(LICENSE_FILE);

        // Execute core demonstration
        try {
            renderZipArchive();
        } catch (Exception e) {
            System.err.println("Error during rendering: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
