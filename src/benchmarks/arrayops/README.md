Array Operation Strategy
========================

The implementation of an array must use the right type always. For the interfaces
of the methods accessing an array I tried:

-- Object based (usual boxing)
-- Long based (miniboxing)
-- Raw (ideal - with the correct type)

For the miniboxing approach I tried several implementation of demultiplexing:

-- class tags + if branches
-- class tags + switch
-- snippet based 

Results
-------

For each strategy I used an array of Boolean, Int, Double (except for the first one):

size = 200000
T = 200

<pre>
boxed took 709.0ms

raw took 429.0ms
raw took 315.0ms
raw took 351.0ms

specialized took 733.0ms
specialized took 718.0ms
specialized took 723.0ms

snippet took 1148.0ms
snippet took 1092.0ms
snippet took 1149.0ms

switch-classtag took 793.0ms
switch-classtag took 834.0ms
switch-classtag took 797.0ms

if-classtag took 815.0ms
if-classtag took 832.0ms
if-classtag took 932.0ms
</pre>

def size = 2000
def T = 20000

<pre>
boxed took 2021.0ms
raw took 313.0ms
raw took 434.0ms
raw took 704.0ms
specialized took 7192.0ms
specialized took 7135.0ms
specialized took 7144.0ms
snippet took 11127.0ms
snippet took 10869.0ms
snippet took 11424.0ms
switch-classtag took 7851.0ms
switch-classtag took 8220.0ms
switch-classtag took 7877.0ms
if-classtag took 8378.0ms
if-classtag took 8363.0ms
if-classtag took 9102.0ms
</pre>

Looking at the JIT log, I noticed that in the second set of tests, for Boxed, and Raw 
strategies, as they have an individual run method, it is complied and optimized, so
the access methods are inlined and the overhead of calling them is eliminated.

I repeated the measurement with the 'run' method implemented in each ArrayClass rather
than in the interface. The results are quite confusing :D

<pre>
boxed took 200.0ms

raw took 31.0ms
raw took 44.0ms
raw took 72.0ms

specialized took 35.0ms
specialized took 43.0ms
specialized took 75.0ms

snippet took 843.0ms
snippet took 555.0ms
snippet took 818.0ms

switch-classtag took 46.0ms
switch-classtag took 199.0ms
switch-classtag took 77.0ms

if-classtag took 49.0ms
if-classtag took 282.0ms
if-classtag took 413.0ms
</pre>