# selenium-ecotime

selenium-ecotime is a command line interface (CLI) tool to rapidly enhance the speed at which [UC San Diego Eco-Time](http://ecotimecampus.ucsd.edu/) can be logged per day. Written in Java, using the Selenium franeworkfor the browser automation.

**Fun fact:** UC San Diego Eco-Time is set up in an interesting way from the HTML structure, using frames to support nested browsing, but from the user perspective, seems like a relatively cohesive experience. It made for a fun learning experience alongside with familiarizing myself with Xpath selectors, and the importance of switching frames properly in Selenium.

**Features to be considered for the future would be:** more robust safe-guards for formatting, proper user setting storage, enhanced CLI dialogue, option to clock in time for multiple dates at once, option to complete time-sheet, etc.

## Requirements

This CLI tool requires Java, Google Chrome, Chrome Webdriver, and Selenium to run.

As this CLI tool was developed on a Linux machine, to get set-up, I'll refer you to the [Geeks for Geeks](https://www.geeksforgeeks.org/how-to-install-selenium-tools-on-linux/) article that I used to get my environment set-up for this.

## Set-up

In order to use this, you'll have to enter your Active Directory (AD) user credentials, the times you clock in and clock out regular, your job code, and your pay code - all within `Settings.java`.

**_(Once edited, please do not EVER share your Settings.java with anyone)_**

From that point, run the the file `TerminalLogic.java` from the terminal to start interacting with the CLI.

To do this, open up your terminal then type in `javac TerminalLogic.java`. Then type in `java TerminalLogic`, and follow the text prompts.

## FAQ

> ### How do I format my AD username?

Instead of doing something like "jdoe@ucsd.edu", just set the variable to **"jdoe"** instead.

> ### Where can I view my job code?

When you normally look through UC San Diego Ecotime on your timesheets, select any of the "Select Position ID" drop-down menus, and look for the number that's after "Job Code". 

Alternatively, go to [UCSD Title and Pay](http://hr.ucsd.edu/tpp/index.aspx), and look up your position by job title. In the search results that show up, you'll see the corresponding title code, aka your job code.

> ### Something's broken!

This program was not defensively written, so if you don't properly format your variable values yourself, the program may not run, or may crash during the automated browser process. Please refer to the comments within `Settings.java` for how to format things properly. 

If it crashes in the beginning during the 2FA section, it's possible that you took too long to respond to the 2FA in time, and need to restart the program. Alternatively, you could adjust the `waitFor2FA` integer value within `Settings.java` to give yourself more time.

If it crashes towards the end due to the payCode, it's most likely a matter of increasing the `waitForSelect` integer value within `Settings.java` accordingly.

## MIT License

MIT License

Copyright (c) 2022 Issac In

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.