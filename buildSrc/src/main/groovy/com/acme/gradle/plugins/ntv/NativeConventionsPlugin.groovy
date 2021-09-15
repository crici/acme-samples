package com.acme.gradle.plugins.ntv

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.model.RuleSource
import org.gradle.language.cpp.plugins.CppLibraryPlugin
import org.gradle.language.cpp.CppApplication
import org.gradle.language.cpp.CppSharedLibrary
import org.gradle.api.logging.Logger

class NativeConventionsPlugin implements Plugin<Project> {

    Logger log

    void apply( Project project ) {
        log = project.logger

        configureCppLibraries(project)
        configureCppApplications(project)
    }

    void configureCppLibraries( Project project ) {
        if ( project.pluginManager.hasPlugin('cpp-library') ) {
            
            log.info "[NXP DEBUG]  cpp-library  plugin applied."

            project.library {
                binaries.configureEach { binary ->
                    def compileTask = compileTask.get()

                    if ( binary instanceof CppSharedLibrary ) {
                        log.info "[NXP DEBUG]  Setting macro  BUILD_SHARED_LIBRARY to 1"
                        compileTask.macros.put("BUILD_SHARED_LIBRARY", "1")
                    }
                }
            }

        }
    }

    void configureCppApplications( Project project ) {
        if ( project.pluginManager.hasPlugin('cpp-application') ) {
            
            log.info "[NXP DEBUG]  cpp-application  plugin applied."

            project.library {
                binaries.configureEach { binary ->
                    def compileTask = compileTask.get()
                    def linkTask = linkTasgk.get()

                    if ( binary instanceof CppApplication ) {
                        log.info "[NXP DEBUG]  Setting macro  BUILD_SHARED_LIBRARY to 1"
                        compileTask.macros.put("STATIC_LINKAGE", "1")
                        linkTask.args.add("-static")
                    }
                }
            }

        }
    }

}
