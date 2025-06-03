# Scala Lab

A Scala 3 project built with [Bleep](https://github.com/oyvindberg/bleep) build tool, featuring CLI applications, native compilation, and comprehensive testing.

## Prerequisites

- **GraalVM Community 23.0.1** - The project uses GraalVM for JVM runtime and native compilation
- **Bleep 0.0.12** - Build tool for Scala projects
- **Scala 3.3.5** - The project is built with Scala 3

### Installing Prerequisites

1. **Install GraalVM Community 23.0.1**:
   ```bash
   # Using SDKMAN (recommended)
   sdk install java 23.0.1-graalce
   sdk use java 23.0.1-graalce
   ```

2. **Install Bleep**:
   ```bash
   # Using coursier (recommended)
   cs install --contrib bleep
   
   # Or download from releases
   # https://github.com/oyvindberg/bleep/releases
   ```

## Project Structure

The project consists of four main modules:

### 📦 Modules

- **`cli/`** - Command-line interface application
- **`native/`** - Native compiled application using Scala Native
- **`scripts/`** - Build scripts for native image generation
- **`tests/`** - Test suite using MUnit framework

### 🛠️ Key Features

- **Scala 3.3.5** with strict compilation settings
- **Native compilation** with Scala Native
- **Cross-platform** JVM and native builds
- **Comprehensive testing** with MUnit
- **Modern build system** using Bleep

## Usage

### Building the Project

```bash
# Compile all modules
bleep compile

# Compile specific module
bleep compile cli
bleep compile native
```

### Running Applications

#### CLI Application (JVM)
```bash
# Run the CLI application on JVM
bleep run cli

# Or with arguments
bleep run cli -- arg1 arg2
```

#### Native Application
```bash
# First build the native application
bleep run scripts  # This runs the native image build script

# The native executable will be created as 'foo-app'
./foo-app

# Or run directly with Bleep
bleep run native
```

### Running Tests

```bash
# Run all tests
bleep test

# Run tests for specific module
bleep test tests

# Run tests with verbose output
bleep test tests --verbose

# Run specific test suites
bleep test tests --test-only "YourTestSuite"
```

### Development Workflow

```bash
# Clean build artifacts
bleep clean

# Continuous compilation (watches for file changes)
bleep compile --watch

# Continuous testing
bleep test --watch

# Check project configuration
bleep projects
```

### Scala Native app

The project includes a Scala Native app

```bash
# Build native executable
bleep run native

# The native executable 'foo-app' will be created with:
# - Immix garbage collector for better performance
# - Optimized for size and startup time
# - Statically linked dependencies
```

## Configuration

The project configuration is managed through `bleep.yaml`:

- **JVM**: GraalVM Community 23.0.1
- **Scala Version**: 3.3.5 with strict compilation
- **Native GC**: Immix (optimized for performance)
- **Test Framework**: MUnit 1.1.0
- **Dependencies**: Fansi for terminal formatting

## Common Commands

| Command | Description |
|---------|-------------|
| `bleep compile` | Compile all modules |
| `bleep run cli` | Run CLI application |
| `bleep run native` | Run native application |
| `bleep run scripts` | Build native executable |
| `bleep test` | Run all tests |
| `bleep clean` | Clean build artifacts |
| `bleep projects` | List all projects |

## Troubleshooting

### Native Image Build Issues
- Ensure GraalVM is properly installed and `JAVA_HOME` points to GraalVM
- Check that `native-image` tool is available in PATH
- For reflection/serialization issues, add configuration files to `META-INF/native-image/`

### Test Failures
- Run tests with `--verbose` flag for detailed output
- Check test dependencies in `bleep.yaml`
- Ensure test files follow MUnit conventions

### Build Performance
- Use `--watch` mode for development
- Consider parallel compilation: `bleep compile --parallel`
- Clean build if experiencing cache issues: `bleep clean`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests: `bleep test`
5. Submit a pull request

## License

[Add your license information here] 