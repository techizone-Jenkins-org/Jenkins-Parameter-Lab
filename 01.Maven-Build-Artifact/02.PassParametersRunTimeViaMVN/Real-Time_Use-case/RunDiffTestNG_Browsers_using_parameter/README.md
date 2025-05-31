# Pass Parameters to the Maven Command

## Prerequisites to run these Project is Install Browsers {chrome, Firefox, Edge}

### Install Chrome Browser in RHEL
```
wget https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
sudo dnf localinstall google-chrome-stable_current_x86_64.rpm -y
sudo rpm --import https://dl.google.com/linux/linux_signing_key.pub
google-chrome --version
```
### Install Firefox Browser in RHEL
```
sudo dnf install firefox -y
firefox --version
```

### Install Edge Browser in RHEL
```
sudo tee /etc/yum.repos.d/microsoft-edge.repo <<EOF
[microsoft-edge]
name=Microsoft Edge
baseurl=https://packages.microsoft.com/yumrepos/edge
enabled=1
gpgcheck=1
gpgkey=https://packages.microsoft.com/keys/microsoft.asc
EOF

sudo dnf install microsoft-edge-stable -y
microsoft-edge --version
```
## For headless testing in CI/CD pipelines (like Jenkins), ensure these are installed:
```
sudo dnf install -y \
  mesa-libOSMesa \
  alsa-lib \
  atk \
  cups-libs \
  gtk3 \
  libXcomposite \
  libXcursor \
  libXdamage \
  libXrandr \
  libXScrnSaver \
  libXtst \
  xdg-utils \
  libnss3 \
  libxkbcommon \
  liberation-fonts
```
