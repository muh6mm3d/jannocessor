# New JAnnocessor Project from Maven Archetype in Eclipse #

This tutorial explains how to create a new project that uses JAnnocessor to generate source code, in a few steps, by using the JAnnocessor Sample Archetype from Maven Central Repository.

**1. Go to the "New Maven Project" wizard:**

![http://www.jannocessor.org/archetype1.png](http://www.jannocessor.org/archetype1.png)

**2. Choose the options as shown above.**

**3. Click "Next" to move to the second screen:**

![http://www.jannocessor.org/archetype2.png](http://www.jannocessor.org/archetype2.png)

**4. Select the "Nexus Indexer" catalog, or select "All Catalogs".**

**5. Type "jannocessor" in the filter field, to search for JAnnocessor Maven archetypes.**

**6. Select _jannocessor-sample-arhetype_ in the search results.**

**7. Click "Next" to move to the third screen:**

![http://www.jannocessor.org/archetype3.png](http://www.jannocessor.org/archetype3.png)

**8. Enter project information as shown above.**

**9. Click "Finish" to complete the process.**

As a result, a new multi-module project will be generated (e.g. "experiment"), having 2 modules (e.g. "experiment-annotated" and "experiment-generated"):

![http://www.jannocessor.org/archetype4.png](http://www.jannocessor.org/archetype4.png)

The "x-annotated" module contains annotated classes, annotation processor and their configuration. Running "mvn clean install" should activate the annotation processor and generate the Java source code in the "x-generated" module.