job('perfomance') {
    scm {
        git {
            remote {
                url('https://github.com/mironouz/knuth')
            }
            branch('master')
        }
    }
    steps {
        gradle('jmh')
        shell('chmod +x utils/jmh-report-to-html.py')
        shell('utils/jmh-report-to-html.py build/reports/jmh/results.txt jmh_snippet')
    }
    publishers {
        archiveArtifacts('build/reports/jmh/results.txt')
        richTextPublisher {
            stableText('${FILE:jmh_snippet}')
            parserName('HTML')
            unstableText('')
            failedText('')
            abortedText('')
            unstableAsStable(true)
            failedAsStable(true)
            abortedAsStable(true)
            nullAction('')
        }
    }
}
