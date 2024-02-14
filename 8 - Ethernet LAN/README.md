# EXecute steps

Step 1: Create tcl file and write the code
```
gedit lab3.tcl
```

Step 2: Create awk file and write the code
```
gedit lab3.awk
```

Step 3: Run the TCL program (Forward the steps and Press RUN Button ▶️ )
```
ns lab3.tcl
```

Step 4: Check output of previous step (DONT EDIT ANYTHING!)
```
gedit fil1.tr 
```

Step 5: Execute awk program for given NS output 
```
awk -f lab3.awk file1.tr > xfile1
awk -f lab3.awk file2.tr > xfile2
```

Step 6: Trace the graph for the 2 files
```
xgraph xfile1 xfile2
```
