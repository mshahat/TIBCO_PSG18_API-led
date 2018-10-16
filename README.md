# TIBCO PSG 2018 | API Platform &amp; API-led Integration

As part of this breakout, some exercises are planned, this guide is to help setting up the environment and list labs and artefacts

## Labs
The following labs are planned, click on each for more details

 * [Events Processing Lab 1](https://github.com/mshahat/TIBCO_PSG18_API-led/tree/master/labs/event-processing-lab1)
 * Events Processing Lab 2
 * [API-led Lab 1](https://github.com/mshahat/TIBCO_PSG18_API-led/tree/master/labs/api-lab1)
 * API-led Lab 2

## Prerequisites

Software you need to install and accounts you need to have to be able to carry on the labs during the workshops.

## Operating System
You should be able to run the labs if you are running on the following OS choices

* macOS
* Windows 10
  * **Make sure to enable hardware virtualisation in BIOS**
* Linux e.g. CentOS or Ubuntu

## Accounts

These accounts are needed to run through the labs:
* TIBCO Cloud
  * TIBCO Cloud Mashery
  * TIBCO Cloud Integration

Expected to use the following capabilities 
* TIBCO Cloud Mashery Control Center
* TIBCO Cloud Mashery API Modeling
* TIBCO Cloud Integration, BW
* TIBCO Cloud Integration, Mock up


## Software
Please choose to download and install each requirement. 
Instructions for using a package manager is included. 
* macOS, https://brew.sh/
* Windows 10, https://chocolatey.org/  use Powershell

### Required software
* Text editor e.g. Microsoft VSCode https://code.visualstudio.com/
* Virtualbox > 5.2.18 , to run a vm for the Events Processing lab https://www.virtualbox.org/
* An HTTP client, to test APIs
  * Postman - GUI (free)      https://www.getpostman.com/
  * Httpie - CLI  (free)      https://httpie.org/
  * Paw Cloud     (for a fee) https://paw.cloud/
* Docker
  * Make sure to pull this before arriving to the venue
```shell
docker pull mysql
```

### I. Text Editor 
Feel free to use the text editor of choise. 

_macOS_
```
brew cask install visual-studio-code
```
_Windows 10_
```
C:\> choco install vscode
```

### II. Virtualbox 
For those using vmware fusion or workstation, you could try to import the vm without the need for virtualbox 

_macOS_
```
brew cask install virtualbox
```
_Windows 10_
```
C:\> choco install virtualbox
```

### III. Http client

#### Postman 
_macOS_
```
brew cask install postman
```
_Windows 10_
```
C:\> choco install postman
```

#### Httpie
_macOS_
```
brew install httpie
```
_Windows 10_
```

```
### IV. Docker
_macOS_
https://store.docker.com/editions/community/docker-ce-desktop-mac 

_Windows 10_
https://store.docker.com/editions/community/docker-ce-desktop-windows


items

labs 
lab 1 instructions
lab 1 artefacts
lab 2 instructions
lab 2 artefacts 
