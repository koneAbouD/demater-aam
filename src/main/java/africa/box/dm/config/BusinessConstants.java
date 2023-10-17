package africa.box.dm.config;

public class BusinessConstants {

    public static final String HostUrOfLoanInitiate="http://localhost:8989/";
    public static final String BASE_UPLOAD_PATH = "/home/subhro/tmp";

    public static final class EVENT_TYPES {
        public static final String START_PROCESS = "startProcess";
        public static final String INTERMEDIATE_EVENT_THROWN = "intermediate-event";
        public static final String END_PROCESS = "endProcess";
        public static final String MISSING_DOCS = "missingDocs";
        public static final String ERROR_EVENT = "error";
    }

    public static final class UPLOAD_PROVIDERS {
        public static final String LOCAL = "local";
        public static final String S3 = "s3";
        public static final String AZURE = "azure";
    }

    public static final String DOC_CIP = "Document de la CIP";
    public static final String DOC_CIP_CONJOINT = "Document de la CIP du conjoint";
    public static final String DOC_CODE_CONFIRMATION = "CONFIRMATION";
    public static final String DOC_CODE_CONFIRMATION_CONJOINT = "CONFIRMATION_CONJOINT";
    public static final String DOC_CNI = "Pièce d'identité";
    public static final String DOC_CODE_CNI = "CNI";

}
