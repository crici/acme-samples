#include <iostream>

#include "somelib.h"

#ifdef DEBUG
    #define LOG(message) {\
        std::cout << "[NXP DEBUG]  " << message << std::endl; \
    }
#else
    #define LOG(message)
#endif


int main( int argc, char*argv[] )
{
    int answer = 0;

    answer = somelib_add( 40, 2 );

    LOG("This message appears in DEBUG mode only.")
    
    std::cout << "Consumer got the answer: " << answer << std::endl;

    return 0;
}


