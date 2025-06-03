#!/bin/bash

# Exit on error
set -e

TARGET_DIR="target"
# Create the target directory if it doesn't exist
mkdir -p "$TARGET_DIR"

# Define the output binary name
OUTPUT_NAME="$TARGET_DIR/foo-app"

echo "Building native project..."
bleep compile native

echo "Copying binary to $OUTPUT_NAME..."
cp .bleep/builds/normal/.bloop/native/native.out "$OUTPUT_NAME"
chmod +x "$OUTPUT_NAME"

echo "Native binary created: $OUTPUT_NAME" 