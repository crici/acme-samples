#ifndef SOMELIB_H_INCLUDED
#define SOMELIB_H_INCLUDED


#ifdef _WIN32
    #define SOMELIBAPI
#else
    #define SOMELIBAPI
#endif

SOMELIBAPI int somelib_add( int a, int b );

#endif
