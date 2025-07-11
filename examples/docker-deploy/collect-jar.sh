#!/bin/bash

cd "$(dirname "$0")/../.."

DEPLOY_DIR="examples/docker-deploy"
MODULES=("config" "trading-api" "trading-engine" "trading-sequencer" "quotation" "push" "ui")

for module in "${MODULES[@]}"; do
  JAR_PATH="$module/target"
  rm -f "$module"/*.jar
  if [ -d "$JAR_PATH" ]; then
    for jar in "$JAR_PATH"/*.jar; do
      if [ -f "$jar" ]; then
        echo "Copying $jar to $DEPLOY_DIR"
        cp "$jar" "$DEPLOY_DIR/$module"
      fi
    done
  fi
done

echo "All jars copied to $DEPLOY_DIR"