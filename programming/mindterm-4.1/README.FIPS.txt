**** MindTerm/FIPS ****

The MindTerm code has been restructured to use the normal Java crypto APIs, 
and the relevant MindTerm crypto code is now a JCE in itself. It is however
not signed, so in order to use the MindTerm JCE you will need a Java version 
that allows the running of unsigned JCEs, like openjdk. But this is usually
not a problem since the whole idea is to use a 3rd party, signed, FIPS-compliant
JCE.

To use a 3rd party (FIPS) JCE you will need to tell MindTerm:

 1) how to load the JCE  (-Dmindterm.jce.provider=<jce-class>)
 2) the preferred JCE provider name (-Dmindterm.jce.preferred=<jce-id>)
 3) if the preferred JCE should be the only JCE providing crypto methods
        (-Dmindterm.jce.preferredonly=yes/no)
 4) if we want to use a specific PRNG from this JCE
       (-Dmindterm.jce.prng=<prng-name>)
 5) if we want to run in FIPS-mode (-Dmindterm.jce.fipsmode=yes/no)

So, for example, when using the IBM JCE FIPS provider, this translates to 
starting MindTerm like this:

java \
 -Dmindterm.jce.provider=com.ibm.crypto.fips.provider.IBMJCEFIPS \
 -Dmindterm.jce.preferred=IBMJCEFIPS \
 -Dmindterm.jce.preferredonly=yes \
 -Dmindterm.jce.prng=IBMSecureRandom \
 -Dmindterm.jce.fipsmode=yes \
 -cp mindterm.jar:ibmjcefips.jar:ibmpkcs.jar \
  com.mindbright.application.MindTerm

You can also add '-Dmindterm.jce.debug=yes' to see which crypto methods/classes are
loaded.

In FIPS mode only SSH2 can be used, and the SSH2 crypto methods are restricted to:

  Key exchange: diffie-hellman-group14-sha1
  Host key algorithm: ssh-rsa
  Ciphers: aes128-cbc,aes192-cbc,aes256-cbc,3des-cbc
  Macs: hmac-sha1,hmac-sha2-256,hmac-sha256-2@ssh.com,hmac-sha256@ssh.com

MindTerm will always try to load the BouncyCastle JCE (if it is on your classpath)
unless fipsmode is set to 'true'.
