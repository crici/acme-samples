#ifndef SOMELIB_H_INCLUDED
#define SOMELIB_H_INCLUDED


#ifdef _WIN32
    #ifdef BUILD_SHARED_LIBRARY
        #define SOMELIBAPI __declspec(dllexport)
    #else
        #ifdef STATIC_LINKAGE
            #define SOMELIBAPI  
        #else
            #define SOMELIBAPI __declspec(dllimport)
        #endif
    #endif
#else
    #define SOMELIBAPI
#endif

#ifdef __cplusplus
extern "C" {
#endif

SOMELIBAPI int somelib_add( int a, int b );

#ifdef __cplusplus
}
#endif

#endif
