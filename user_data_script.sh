#!/bin/bash -ex
# output user data logs into a separate file for debugging
exec > >(tee /var/log/user-data.log|logger -t user-data -s 2>/dev/console) 2>&1

# download nvm
#curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
# source nvm
#. /.nvm/nvm.sh
# install node
#nvm install node
#export NVM dir
#export NVM_DIR="/.nvm"
#[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
#[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"

#update apt
sudo apt-get update

#install java
sudo apt install openjdk-8-jre-headless -y

#install git
sudo apt-get install git -y
cd /home/ubuntu
# get source code from github
git clone https://github.com/ruwan-jayaweera/demo-app.git
#get in project dir
cd demo-app
#give permission
sudo chmod -R 755 .

#install node module
#npm install
# start the app
#node app.js > app.out.log 2> app.err.log < /dev/null &
java -jar bin/demo-app-0.0.1-SNAPSHOT.jar