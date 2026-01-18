# GroupDocs Viewer Java Render ZIP Archives Showcase

## Overview
This **showcase project** demonstrates how to use the **GroupDocs Viewer** Java library (v25.12) to render the contents of a **ZIP archive** into PNG images. The example reads a sample ZIP file from the `resources/input/` directory and writes the rendered images to `resources/output/`.

## Prerequisites
- **Java Development Kit (JDK) 8** or higher
- **Apache Maven** 3.5+ installed and available in your `PATH`
- Internet connection to download the GroupDocs Maven repository artifacts (the first time you build the project)

## License
GroupDocs Viewer requires a license file to run without evaluation restrictions.

1. **Obtain a temporary license** (free 30‑day trial) from: https://purchase.groupdocs.com/temporary-license/
2. **Place the license file** (`GroupDocs.Viewer.Java.lic`) in the **project root directory** (same level as `pom.xml`).
3. **Without a license**, the library works in evaluation mode, which adds watermarks and may limit certain features.

> **Note:** The license file is **not** included in this repository. You must add it manually.

## Project Structure
```
groupdocs-viewer-java-render-zip-archives/
├─ pom.xml
├─ resources/
│  ├─ input/
│  │   └─ sample.zip      # placeholder ZIP – replace with your own archive
│  └─ output/             # generated images will appear here
├─ src/
│  └─ main/java/com/groupdocs/viewer/examples/RenderZipArchivesExample.java
└─ README.md
```

- **`resources/input/`** – place the ZIP archive you want to render here.
- **`resources/output/`** – the rendered HTML files are saved to this folder automatically.

## Setup & Build
1. **Clone the repository** (or copy the files into a new directory):
   ```bash
   git clone <repository-url>
   cd groupdocs-viewer-java-render-zip-archives
   ```
2. **Add your license file** (`GroupDocs.Viewer.Java.lic`) to the project root if you have one.
3. **Build the project** and download dependencies:
   ```bash
   mvn clean compile
   ```

## Run the Example
You can run the example using Maven's Exec plugin.

### Using Maven Exec Plugin
```bash
mvn exec:java
```

The program will:
1. Attempt to load `GroupDocs.Viewer.Java.lic` (if present).
2. Render the ZIP archive located at `resources/input/sample.zip`.
3. Write the resulting PNG files into `resources/output/` using the `result_{0}.png` naming pattern.

## Replacing the Sample Input
The repository contains a placeholder `sample.zip`. To see real rendering results:
1. Delete or overwrite `resources/input/sample.zip` with your own ZIP archive containing supported document types (e.g., `.docx`, `.pdf`, `.txt`).
2. Re‑run the example as described above.

## Additional Notes
- The example uses `PngViewOptions`, so each rendered page is saved as a PNG image.
- Ensure the output directory has write permissions.
- For more advanced scenarios (custom rendering options, streaming, etc.), refer to the official GroupDocs Viewer Java documentation.

---
*This project is intended as a quick start guide and showcase for developers interested in integrating GroupDocs Viewer into their Java applications.*