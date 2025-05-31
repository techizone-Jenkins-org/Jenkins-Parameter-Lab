#!/bin/bash

set -e

echo "============================="
echo " Installing Web Browsers... "
echo "============================="

# Update the system
echo "[INFO] Updating system packages..."
sudo dnf update -y

# ---------------------------
# 1. Install Google Chrome
# ---------------------------
echo "[INFO] Installing Google Chrome..."
wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
sudo dnf install -y ./google-chrome-stable_current_x86_64.rpm
rm -f google-chrome-stable_current_x86_64.rpm
google-chrome --version

# ---------------------------
# 2. Install Firefox
# ---------------------------
echo "[INFO] Installing Firefox..."
sudo dnf install -y firefox
firefox --version

# ---------------------------
# 3. Install Microsoft Edge
# ---------------------------
echo "[INFO] Setting up Microsoft Edge repo..."
sudo rpm --import https://packages.microsoft.com/keys/microsoft.asc

sudo tee /etc/yum.repos.d/microsoft-edge.repo > /dev/null <<EOF
[microsoft-edge]
name=Microsoft Edge
baseurl=https://packages.microsoft.com/yumrepos/edge
enabled=1
gpgcheck=1
gpgkey=https://packages.microsoft.com/keys/microsoft.asc
EOF

echo "[INFO] Installing Microsoft Edge..."
sudo dnf install -y microsoft-edge-stable
microsoft-edge --version

echo "======================================"
echo " All browsers installed successfully! "
echo "======================================"
