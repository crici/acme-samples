#include "somelib.h"

#ifdef __cplusplus
extern "C" {
#endif


SOMELIBAPI int somelib_add( int a, int b ) {
    return a+b;
}


#ifdef __cplusplus
}
#endif