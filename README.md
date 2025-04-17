

# File Search API

This project is an implementation of a flexible and extensible File Search API, designed using Object-Oriented Design (OOD) principles. It supports querying files within a directory structure based on parameters such as file extension, name, and size, with support for logical `AND` and `OR` constraint combinations.

**Design Reference:**  
This system is modeled based on the design principles outlined in the [OOD File Search Design](https://github.com/ycwkatie/OOD-Object-Oriented-Design/blob/main/ood/file_search.md) from the OOD-Object-Oriented-Design repository.

---

## Key Components and Interacting Objects

The system is designed around the Specification Pattern, enabling composable and reusable filtering logic.

- **FileSearchSystem**: Main controller that initiates the recursive directory traversal and applies specifications to filter files.
- **Entry**: Abstract class for both files and directories. Each entry has a name and size.
- **File**: Represents an actual file with byte content. Provides access to extension and size.
- **Directory**: Represents a folder containing other `Entry` objects (files or sub-directories).
- **Param**: Captures query parameters such as `name`, `extension`, `minSize`, and `maxSize`.
- **Specification**: Interface for defining flexible filtering logic. Each specification implements `isSatisfied(...)`.
- **Concrete Specifications**:  
  - `ExtensionSpecification`  
  - `NameSpecification`  
  - `MinSizeSpecification`  
  - `MaxSizeSpecification`
- **Combinator Specifications**:
  - `AndSpecification` – applies logical AND between two specifications  
  - `OrSpecification` – applies logical OR between two specifications

---

## User Action Flow

The File Search API allows developers to filter files by combining one or more specifications:

1. **Define Search Parameters**  
   Instantiate a `Param` object to define the desired file properties (e.g., extension, name, size range).

2. **Construct Specifications**  
   Create one or more `Specification` objects (e.g., `ExtensionSpecification`, `MinSizeSpecification`) to apply constraints.

3. **Compose Specifications** (Optional)  
   Use `AndSpecification` or `OrSpecification` to combine multiple filters.

4. **Search Using FileSearchSystem**  
   Pass the root `Directory`, composed `Specification`, and `Param` to the `FileSearchSystem.search()` method.  
   The method returns a list of matching `File` objects.

---

## Getting Started

To run the project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/file-search-api.git
   ```

2. Navigate into the project folder:
   ```bash
   cd file-search-api
   ```

3. Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).

4. Compile and run:
   Ensure your environment supports **Java 8+**.

---

## Usage Example

```java
Directory rootDir = new Directory("root");

File file1 = new File("report.pdf", content);
File file2 = new File("notes.txt", content);
File file3 = new File("image.png", content);

rootDir.addEntry(file1);
rootDir.addEntry(file2);
rootDir.addEntry(file3);

Param params = new Param("txt", 0, 1000, "notes.txt");

Specification extSpec = new ExtensionSpecification();
Specification nameSpec = new NameSpecification();

Specification combined = new AndSpecification(extSpec, nameSpec);

FileSearchSystem searchSystem = new FileSearchSystem();
List<File> results = searchSystem.search(rootDir, combined, params);
```

---

## Project Structure

| Component             | Responsibility                                         |
|----------------------|---------------------------------------------------------|
| `Entry`, `File`, `Directory` | Represent files and folders with common behavior        |
| `Param`              | Captures user-defined search filters                    |
| `Specification`      | Interface for evaluating a file against constraints     |
| `ExtensionSpecification`, `MinSizeSpecification`, etc. | Concrete filters by property       |
| `AndSpecification`, `OrSpecification` | Logical combinators for multiple constraints      |
| `FileSearchSystem`   | Coordinates recursive traversal and applies filters     |

